Bitcask is an Erlang application that provides an API for storing and
retrieving key/value data into a log-structured hash table.
The design owes a lot to the principles found in log-structured file systems
and draws inspiration from a number of designs that involve log file merging.


Bitcask是一个Erlang应用程序，它提供了一个API，用于将键/值数据存储和检索到日志结构的哈希表中。
该设计很大程度上归功于日志结构文件系统中的原理，并从涉及日志文件合并的许多设计中汲取灵感。
illustrated：图例

首先：我们测试了一个 tail -n 1 从文件末尾读取插入的数据
    我们的 db_get 方法 每次都是 从头到尾遍历 database,获取对应 key 的value
    这在数据量很大的时候是个灾难,并且随着数据量的增长 查询时间 会随着增长
    于是我们引入 索引
第一种索引：Hash Indexes
    RAM：内存
    all the keys fit in the available RAM，所有的key都在内存中，而值可以存储在内存之外的其他地方。
    类似 Bitcask 的存储引擎适合于频繁修改一个 key 的值的情况。
Question：如何避免最终耗尽磁盘？
    一种思路：通过在达到特定大小时关闭段文件，将日志分成一定大小的段，而新的写入会开启一个新的segment。
        Compaction of a key-value update log (counting the number of times each cat video was played), retaining only the most recent value for each key.
        我们把合并和压缩放在后台进程进行，此时仍可以正常从旧的segment中读写。
        当合并之后，旧的文件可以被删除，切换到新的 segment 上读写。
        1、删除数据时候只是把删除逻辑附加到数据文件中，即逻辑删除，等到一次 merge 操作时才会真正丢弃 key 及其关联值。
        2、数据格式：CSV格式存储占空间并且慢，最好的方式是二进制文件。
        3、Crash recovery：崩溃恢复
            最佳办法是在 磁盘上 备份快照，当数据库重启内存中数据会丢失，这个时候如果重新 从头到尾 读取大segment，代价太大。
            备份快照，重启之后直接将快照加载到 内存中。
        4、并发控制
            只让一个进程写，多个进程读。
        局限：
        1、hash table 只适合于内存，如果key值很多需要在磁盘上存储不适合用hash table，
           增加随机 I/O，当磁盘接近满的时候代价是非常昂贵的。此外 hash 碰撞会导致计算逻辑更复杂。
        2、hash table 不能一次进行多个 key 范围扫描，一次只能查询 单个key。
        
        接着我们引入 indexing struct：索引树
        
第二种索引数：SSTables and LSM-Trees  
take precedence over：优先于
 
    
    