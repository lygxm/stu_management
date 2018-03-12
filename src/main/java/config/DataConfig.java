package config;

import javax.sql.DataSource;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import domain.Classes;
import domain.Student;
import org.apache.ibatis.datasource.jndi.JndiDataSourceFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.Alias;
import org.apache.ibatis.type.TypeAliasRegistry;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.jndi.JndiObjectFactoryBean;

import java.beans.PropertyVetoException;

@Configuration
public class DataConfig {

//    @Bean
//    @Primary
//    public DataSource jndiDataSource() {
//        JndiObjectFactoryBean jndiObjectFactoryBean =
//                new JndiObjectFactoryBean();
//        jndiObjectFactoryBean.setJndiName("java:comp/env/jdbc/test");
//        return (DataSource)jndiObjectFactoryBean.getObject();
//    }

    @Bean
    @Primary
    public DataSource h2DataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("schema.sql")
                .build();
    }

    @Bean
    public DataSource c3p0dataSource()  {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        try {
            cpds.setDriverClass( "com.mysql.jdbc.Driver" );
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        cpds.setJdbcUrl( "jdbc:mysql://localhost:3306/test" );
        cpds.setUser("peter");
        cpds.setPassword("123456");

        cpds.setMinPoolSize(5);
        cpds.setAcquireIncrement(5);
        cpds.setMaxPoolSize(20);

        return cpds;
    }



    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean
                = new SqlSessionFactoryBean();

        sqlSessionFactoryBean.setDataSource(dataSource);

        Resource[] mappers = new ClassPathResource[]{
                new ClassPathResource("mappers/StudentRepositoryMapper.xml"),
                new ClassPathResource("mappers/ClassesRepositoryMapper.xml"),
        };
        sqlSessionFactoryBean.setMapperLocations(mappers);

        Class[] aliases = new Class[]{Student.class, Classes.class,};
        sqlSessionFactoryBean.setTypeAliases(aliases);

        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer
                = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("repository");
        return mapperScannerConfigurer;
    }
}
