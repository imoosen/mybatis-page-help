package com.allinpay.wjt.config;

import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by mengsen on 2017/9/28.
 *
 * @Description: [一句话描述该类的功能]
 * @UpdateUser: mengsen on 2017/9/28.
 */
@Slf4j
@Configuration
@EnableTransactionManagement // 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
@MapperScan("com.allinpay.wjt.mapper")
public class MyBatisConfig implements TransactionManagementConfigurer, EnvironmentAware{

    @Autowired
    DataSource dataSource;

   /* @Autowired
    private PageHelper pageHelper;*/

    private RelaxedPropertyResolver propertyResolver;
    @Override
    public void setEnvironment(Environment environment) {
        this.propertyResolver = new RelaxedPropertyResolver(environment, "mybatis.");
    }
   /* @Bean(name="pageHelper")
    public PageHelper pageHelper(){
        //分页插件
        PageHelper pageHelper = new PageHelper();
        Properties props = new Properties();
        props.setProperty("reasonable", "true");
        props.setProperty("supportMethodsArguments", "true");
        props.setProperty("returnPageInfo", "check");
        props.setProperty("params", "count=countSql");
        pageHelper.setProperties(props);
        return pageHelper;
    }*/
    @Bean
    public SqlSessionFactory sqlSessionFactory() {
        try {
            SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
            sessionFactory.setDataSource(dataSource);
            sessionFactory.setTypeAliasesPackage(propertyResolver
                    .getProperty("typeAliasesPackage"));
            sessionFactory
                    .setMapperLocations(new PathMatchingResourcePatternResolver()
                            .getResources(propertyResolver
                                    .getProperty("mapperLocations")));
            sessionFactory
                    .setConfigLocation(new DefaultResourceLoader()
                            .getResource(propertyResolver
                                    .getProperty("configLocation")));
            //sessionFactory.setPlugins(new Interceptor[]{pageHelper});
            return sessionFactory.getObject();
        } catch (Exception e) {
            log.error("Create sqlSessionFactory failed",e);
            log.warn("Could not configure mybatis session factory");
            return null;
        }
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }


}
