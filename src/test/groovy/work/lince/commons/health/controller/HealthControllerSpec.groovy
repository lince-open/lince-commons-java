package work.lince.commons.health.controller

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import spock.lang.Specification
import spock.lang.Unroll

import java.security.Principal

class HealthControllerSpec extends Specification {

    HealthController healthController;

    def setup() {
        healthController = Spy(HealthController)
    }

    @Unroll
    def "health with #user"() {
        given:
            def principal = new UsernamePasswordAuthenticationToken(user, user)
        when:
            def result = healthController.health(principal)

        then:
            result != null
            result.status == "ok"
            result.user == user

        where:
            user    | _
            "name1" | _
            "name2" | _
            "name3" | _
            "name4" | _


    }

}