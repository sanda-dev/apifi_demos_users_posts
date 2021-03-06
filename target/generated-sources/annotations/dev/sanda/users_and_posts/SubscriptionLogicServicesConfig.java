package dev.sanda.users_and_posts;

import dev.sanda.apifi.service.api_logic.SubscriptionsLogicService;
import dev.sanda.users_and_posts.model.Comment;
import dev.sanda.users_and_posts.model.Post;
import dev.sanda.users_and_posts.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * SubscriptionLogicServicesConfig SubscriptionLogicService beans generated by dev.sanda @2021-10-31T12:03:36.589433398 */
@Configuration
class SubscriptionLogicServicesConfig {
  @Bean
  public SubscriptionsLogicService<User> userSubscriptionLogicService() {
    return new SubscriptionsLogicService(User.class);
  }

  @Bean
  public SubscriptionsLogicService<Post> postSubscriptionLogicService() {
    return new SubscriptionsLogicService(Post.class);
  }

  @Bean
  public SubscriptionsLogicService<Comment> commentSubscriptionLogicService() {
    return new SubscriptionsLogicService(Comment.class);
  }
}
