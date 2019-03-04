package com.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	  @Override
	public void configure(WebSecurity web) throws Exception {
	        web.ignoring().antMatchers(
	                "/img/**",
	                "/css/**",
	                "/js/**"
	                );
	  }
	  
  final String LOGIN_PAGE = "/login";
	
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
          // アクセス権限の設定
          // staticディレクトリにある、'/css/','fonts','/js/'は制限なし
          .antMatchers("/",LOGIN_PAGE)
          .permitAll()
          // 他は制限なし
          .anyRequest().authenticated()
        .and()
          // ログイン処理の設定
          .formLogin()
            // ログイン処理のURL
            .loginPage(LOGIN_PAGE)
            // usernameのパラメタ名
            .usernameParameter("username")
            // passwordのパラメタ名
            .passwordParameter("password")
            .failureUrl(LOGIN_PAGE)
            .defaultSuccessUrl("/top")
            .permitAll()
        .and()
          // ログアウト処理の設定
          .logout()
            // ログアウト処理のURL
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            // ログアウト成功時の遷移先URL
            .logoutSuccessUrl(LOGIN_PAGE)
            // ログアウト時に削除するクッキー名
            .deleteCookies("JSESSIONID")
            // ログアウト時のセッション破棄を有効化
            .invalidateHttpSession(true)
            .permitAll()
        ;
    }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	  // インメモリでの暫定対応
	  PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
	  auth.inMemoryAuthentication()
      	// ユーザ名'user', パスワード'user',ロール'USER'のユーザを追加
      	.withUser("user").password(passwordEncoder.encode("pass")).roles("USER");
  }
}