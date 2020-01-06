package work.lince.commons.authentication;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class AuthenticationFeignInterceptor implements RequestInterceptor {

    @Value("${lince.userName:lince.user.name}")
    protected String userNameHeader;

    @Autowired
    protected AuthenticationService authenticationService;

    @Override
    public void apply(RequestTemplate requestTemplate) {
        log.error("passou ........................ {}={}", userNameHeader, authenticationService.getAuthenticatedUser());
        requestTemplate.header(userNameHeader, authenticationService.getAuthenticatedUser());
    }
}