package dev.sanda.users_and_posts.model;

import dev.sanda.datafi.persistence.GenericDao;
import dev.sanda.datafi.service.DaoCollector;
import java.util.List;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

/**
 * DaoCollectorImpl Dao aggregator for data manager generated by dev.sanda @2021-06-08T12:53:41.022402528 */
@Component
@ComponentScan({ "dev.sanda.users_and_posts.model" })
@EntityScan({ "dev.sanda.users_and_posts.model" })
@EnableJpaRepositories({ "dev.sanda.users_and_posts.model" })
public class DaoCollectorImpl implements DaoCollector {

  @Getter
  @Autowired
  private List<? extends GenericDao> daos;
}
