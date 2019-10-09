package com.soft.demo.Config.datasouceConfig;

/**
 * @author xhs
 * @date 2019/9/22 14:56
 * @since jdk 1.8
 */
//@Configuration
//@MapperScan(basePackages = "com.soft.demo.test1", sqlSessionFactoryRef =  "test1SqlSessionFactory")
public class DataSouce1Config {
//    @Bean(name = "test1DataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.test1")
//    public DataSource testDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "test1SqlSessionFactory")
//    public SqlSessionFactory testSqlSessionFactory(@Qualifier("test1DataSource") DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSource);
//        //读取mybatis配置文件
//         bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapping/test1/*.xml"));
//        return bean.getObject();
//    }
//
//    @Bean(name = "test1TransactionManager")
//    public DataSourceTransactionManager testTransactionManager(@Qualifier("test1DataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
//
//    @Bean(name = "test1SqlSessionTemplate")
//    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("test1SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }

}
