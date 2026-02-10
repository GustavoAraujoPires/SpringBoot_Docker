package github.com.GustavoAraujoPires.libraryapi.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfiguration {

    // @Value → lê valores do application.properties ou application.yml
    // @Configuration → diz ao Spring que essa classe é de configuração
    // @Bean → registra um objeto no contexto do Spring

    @Value("${spring.datasource.url}")
    String url;

    @Value("${spring.datasource.username}")
    String username;

    @Value("${spring.datasource.password}")
    String password;

    @Value("${spring.datasource.driver-class-name}")
    String drive;

    //@Bean
    public DataSource dataSource(){
        DriverManagerDataSource ds = new DriverManagerDataSource();

        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        ds.setDriverClassName(drive);

        return ds;
    }

    // Mais aceito

   // @Bean
    public DataSource hikariDataSource(){
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(password);
        config.setDriverClassName(drive);

        config.setMaximumPoolSize(10); // maximo de conexões liberadas
        config.setMinimumIdle(1); // tamanho inicial do pool
        config.setPoolName("library-db-pool"); // nome
        config.setMaxLifetime(600000); // 600 mil segundos (10 minutos) da aplicação em funcionamento
        config.setConnectionTimeout(100000); // tempo para conseguir uma conexão (1 minuto e 6 segundos) se não conseguir da uma excessão
        config.setConnectionTestQuery("select 1"); // query de teste

        return new HikariDataSource(config);

    }

}
