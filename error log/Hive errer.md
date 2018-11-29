Caused by: java.io.IOException: rename for 
src path: hdfs://**/new_market/za_event_id/p_day=20181127/.hive-staging_hive_2018-11-28_21-56-44_642_4686322542343579782-457/-ext-10000/000000_0 
to dest path:hdfs://**/new_market/za_event_id/p_day=20181127/000000_0 returned false
ERROR : FAILED: Execution Error, return code 1 from org.apache.hadoop.hive.ql.exec.MoveTask. java.io.IOException

尝试：
SET hive.exec.stagingdir=/tmp/hive/ 
SET hive.exec.scratchdir=/tmp/hive/