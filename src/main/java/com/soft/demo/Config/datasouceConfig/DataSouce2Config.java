package com.soft.demo.Config.datasouceConfig;


/**
 * @author xhs
 * @date 2019/9/22 14:56
 * @since jdk 1.8
 */
//@Configuration
//@MapperScan(basePackages = "com.soft.demo.test2", sqlSessionFactoryRef =  "test2SqlSessionFactory")
public class DataSouce2Config {
//    @Bean(name = "test2DataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.test2")
//    public DataSource testDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "test2SqlSessionFactory")
//    public SqlSessionFactory testSqlSessionFactory(@Qualifier("test2DataSource") DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSource);
//        //读取mybatis小配置文件
//        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapping/test2/*.xml"));
//        return bean.getObject();
//    }
//
//    @Bean(name = "test2TransactionManager")
//    public DataSourceTransactionManager testTransactionManager(@Qualifier("test2DataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
//
//    @Bean(name = "test2SqlSessionTemplate")
//    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("test2SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
}
