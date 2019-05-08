package ro.utcluj.service;

import org.springframework.stereotype.Component;
import ro.utcluj.api.AnotherService;

@Component
public class AnotherServiceImpl implements AnotherService {
    @Override
    public int aMethod(int a, int b) {
        return 42 + a - b;
    }
}
