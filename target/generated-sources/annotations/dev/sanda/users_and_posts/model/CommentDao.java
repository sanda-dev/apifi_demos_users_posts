package dev.sanda.users_and_posts.model;

import dev.sanda.datafi.persistence.GenericDao;
import java.lang.Long;
import org.springframework.stereotype.Repository;

/**
 * Comment JpaRepository generated by dev.sanda @2021-06-08T12:53:41.008296200 */
@Repository
public interface CommentDao extends GenericDao<Long, Comment> {}
