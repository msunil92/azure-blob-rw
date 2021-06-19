package com.test;

import org.apache.spark.SparkConf;
import org.apache.spark.sql.SparkSession;

/**
 * @author sunil
 * @project AzureApp
 * @created 2021/06/09 12:25 PM
 */
public class SparkApp {

    public static void main(String[] args) {


        SparkSession spark = SparkSession.builder().appName("test").master("local").getOrCreate();
    }
}
a