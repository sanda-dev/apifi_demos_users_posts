package dev.sanda.users_and_posts.service;

import dev.sanda.apifi.service.api_hooks.ApiHooks;
import dev.sanda.apifi.service.api_logic.ApiLogic;
import dev.sanda.apifi.service.api_logic.SubscriptionsLogicService;
import dev.sanda.datafi.dto.FreeTextSearchPageRequest;
import dev.sanda.datafi.dto.Page;
import dev.sanda.datafi.dto.PageRequest;
import dev.sanda.datafi.service.DataManager;
import dev.sanda.users_and_posts.model.Comment;
import dev.sanda.users_and_posts.model.Post;
import dev.sanda.users_and_posts.model.Reaction;
import dev.sanda.users_and_posts.model.Tag;
import dev.sanda.users_and_posts.model.User;
import graphql.execution.batched.Batched;
import io.leangen.graphql.annotations.GraphQLContext;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import java.lang.Integer;
import java.lang.SuppressWarnings;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PostGraphQLApiService {

  @Autowired
  @Getter
  private ApiLogic<Post> apiLogic;

  @Autowired
  @Getter
  private DataManager<Post> dataManager;

  @Autowired(required = false)
  @Getter
  private ApiHooks<Post> apiHooks;

  @Autowired
  private DataManager<User> userDataManager;

  @Autowired
  private DataManager<Comment> commentsDataManager;

  @Autowired
  private SubscriptionsLogicService<User> userSubscriptionsLogicService;

  @Autowired
  private SubscriptionsLogicService<Comment> commentsSubscriptionsLogicService;

  @PostConstruct
  private void postConstructInit() {
    apiLogic.init(dataManager, apiHooks);
  }

  @SuppressWarnings("deprecation")
  @Batched
  @GraphQLQuery
  public List<User> user(@GraphQLContext List<Post> input) {
    return apiLogic.getEmbedded(input, "user", userDataManager);
  }

  @SuppressWarnings("deprecation")
  @Batched
  @GraphQLQuery
  public List<List<Comment>> comments(@GraphQLContext List<Post> input) {
    return apiLogic.getEntityCollection(
      input,
      "comments",
      null,
      commentsDataManager
    );
  }

  @GraphQLMutation
  public List<Reaction> addReactionsToPost(Post owner, List<Reaction> input) {
    return apiLogic.addToElementCollection(owner, "reactions", input, null);
  }

  @GraphQLMutation
  public List<Reaction> removeReactionsFromPost(
    Post owner,
    List<Reaction> input
  ) {
    return apiLogic.removeFromElementCollection(
      owner,
      "reactions",
      input,
      null
    );
  }

  @GraphQLQuery
  public Page<Reaction> reactionsOfPost(Post owner, PageRequest input) {
    return apiLogic.getPaginatedBatchInElementCollection(
      owner,
      input,
      "reactions",
      null
    );
  }

  @GraphQLQuery
  public Page<Reaction> freeTextSearchReactionsOfPost(
    Post owner,
    FreeTextSearchPageRequest input
  ) {
    return apiLogic.getFreeTextSearchPaginatedBatchInElementCollection(
      owner,
      input,
      "reactions",
      null
    );
  }

  @GraphQLMutation
  public Map<Tag, Integer> addTagCountToPost(
    Post owner,
    Map<Tag, Integer> input
  ) {
    return apiLogic.addToMapElementCollection(owner, "tagCount", input, null);
  }

  @GraphQLMutation
  public Map<Tag, Integer> removeTagCountFromPost(Post owner, List<Tag> input) {
    return apiLogic.removeFromMapElementCollection(
      owner,
      "tagCount",
      input,
      null
    );
  }

  @GraphQLQuery
  public Page<Map.Entry<Tag, Integer>> tagCountOfPost(
    Post owner,
    PageRequest input
  ) {
    return apiLogic.getPaginatedBatchInMapElementCollection(
      owner,
      input,
      "tagCount",
      null
    );
  }

  @GraphQLQuery
  public Page<Map.Entry<Tag, Integer>> freeTextSearchTagCountOfPost(
    Post owner,
    FreeTextSearchPageRequest input
  ) {
    return apiLogic.getFreeTextSearchPaginatedBatchInMapElementCollection(
      owner,
      input,
      "tagCount",
      null
    );
  }
}