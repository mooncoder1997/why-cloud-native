package why.scaffold.security.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import why.scaffold.security.core.entity.User;

/**
 * @className: UserRepository
 * @description:
 * @version: v1.0
 * @date: 2019/8/1 14:00
 * @author: Wang, Haoyue
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByLoginName(String loginName);
}
