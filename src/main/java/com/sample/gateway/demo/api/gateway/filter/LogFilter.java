package com.sample.gateway.demo.api.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class LogFilter implements WebFilter {

  @Override
  public Mono<Void> filter(ServerWebExchange serverWebExchange, WebFilterChain webFilterChain) {
    log.info("Receive request with path: {}, header: {}",
        serverWebExchange.getRequest().getPath(),
        serverWebExchange.getRequest().getHeaders());

    return webFilterChain.filter(serverWebExchange);
  }
}
