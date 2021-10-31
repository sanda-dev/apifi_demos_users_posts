package dev.sanda.users_and_posts;

import dev.sanda.datafi.code_generator.BasePackageResolver;
import dev.sanda.datafi.service.DataManager;
import dev.sanda.users_and_posts.model.Comment;
import dev.sanda.users_and_posts.model.Post;
import dev.sanda.users_and_posts.model.User;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * DataManagersConfig Data manager beans generated by dev.sanda @2021-10-31T12:03:36.602301735 */
@Configuration
class DataManagersConfig {
  @Bean
  @Primary
  public DataManager nullTypeDataManager() {
    return new DataManager();
  }

  @Bean
  public DataManager<User> userDataManager() {
    return new DataManager(User.class);
  }

  @Bean
  public DataManager<Post> postDataManager() {
    return new DataManager(Post.class);
  }

  @Bean
  public DataManager<Comment> commentDataManager() {
    return new DataManager(Comment.class);
  }

  @Bean
  public BasePackageResolver basePackageResolver() {
    List<String> packageNames = new ArrayList<String>();
    packageNames.add("dev.sanda.users_and_posts.model");
    return new BasePackageResolver(packageNames);
  }
}
