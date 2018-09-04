package com.oracle.redis;

import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class RedisJava {

    public static void main(String[] args) {

/********************************************1、连接redis服务*****************************************************/
        //连接本地的Redis服务
        Jedis jedis=new Jedis("localhost");
        System.out.println("Redis连接成功！！！");

        //由于我自己的Redis设置了安全管理，所以在此需要密码验证
        //密码验证  我设置的密码为：“root”
        String result=jedis.auth("root");
        System.out.println("密码验证结果："+result);

        //查看服务是否运行
        System.out.println("服务正在运行："+jedis.ping());


/********************************************2、字符串（String） 设置 redis 字符串数据******************************/
        jedis.set("runoobkey","Leecole");    //set user "leecole"
        //获取存储的数据以及输出
        System.out.println("redis 存储的字符串为："+jedis.get("runoobkey"));


/********************************************3、列表 设置 redis 列表数据*******************************************/
        //存储数据到列表dblist中
        jedis.lpush("dblist","redis");
        jedis.lpush("dblist","mongodb");
        jedis.lpush("dblist","mysql");
        jedis.lpush("dblist","sqlserver");
        //获取存取的数据并输出
        jedis.lrange("dblist",0,10);
        //遍历
        List<String> list=jedis.lrange("dblist",0,10);  //集合list的命令行输出：lrange(key,start,end)-----lrange("dblist",0,10)
        for(int i=0;i<list.size();i++){
            System.out.println("列表项为："+list.get(i));
        }

 /********************************************3、keys 设置 redis keys实例*******************************************/
        //获取数据并输出
        Set<String> keys=jedis.keys("*");
        Iterator<String> it=keys.iterator();
        while(it.hasNext()){
            String key=it.next();
            System.out.println(key);
        }
    }


}
