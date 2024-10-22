package sa.bupa.sadirbootstrap.security.service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import sa.bupa.sadirbootstrap.iam.domain.identities.impl.Customer;
import sa.bupa.sadirbootstrap.security.service.SdrUserCacheService;

import java.util.HashMap;
import java.util.Map;
@Service
@Qualifier("sdrIdentityInMemCache")
public class SdrIdentityCacheServiceImpl implements SdrUserCacheService {

    private Map<String, UserDetails> cache = new HashMap<>();

    @Override
    public UserDetails getUserFromCache(String username) {
        return cache.get(username);
    }

    @Override
    public void putUserInCache(UserDetails user) {
        cache.put(((Customer)user).getPrincipal(), user);
    }

    @Override
    public void removeUserFromCache(String username) {
        cache.remove(username);
    }
}
