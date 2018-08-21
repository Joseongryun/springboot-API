package com.infranics.api.asset.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.infranics.api.asset.model.BoardModel;
import com.infranics.api.asset.model.LikeModel;
import com.infranics.api.asset.model.UserModel;

@Configuration
public class SqlSession {
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);

		Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*Mapper.xml");
		sessionFactory.setMapperLocations(res);
		
		sessionFactory.setTypeAliases(new Class<?>[] {UserModel.class, BoardModel.class, LikeModel.class});
		
		return sessionFactory.getObject();
	}
}
