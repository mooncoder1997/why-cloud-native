package why.scaffold.security.core.service;

import com.github.structlog4j.ILogger;
import com.github.structlog4j.SLoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import why.scaffold.security.core.repository.UserRepository;

/**
 * @className: WHYUserDetailService
 * @description: 根据用户名加载用户
 * @version: v1.0
 * @date: 2019/8/1 11:03
 * @author: Wang, Haoyue
 */
@Component("whyUserDetailService")
public class WHYUserDetailService implements UserDetailsService {

    private static final ILogger logger = SLoggerFactory.getLogger(WHYUserDetailService.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("[WHYUserDetailService] loadUserByUsername 登录用户名: " + username);
        return userRepository.findByLoginName(username);
    }
}
