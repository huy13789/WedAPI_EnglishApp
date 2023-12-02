package com.example.WedAPI.config;

import com.example.WedAPI.service.impl.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailService();
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Vô hiệu hóa CSRF
                .csrf(csrf -> csrf.disable())

                // Cấu hình truy cập
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/css/**", "/js/**", "/fonts/**", "/img/**",
                                        "/", "/register", "/error", "/product", "/contact", "/blog",
                                        "/product/category/**", "/home", "/product/search",
                                        "/product/productDetail/**", "/product/page/**").permitAll()  // Cho phép truy cập tài nguyên tĩnh
                                .requestMatchers("/admin/login", "/admin/login?error=true").permitAll()  // Truy cập không xác thực đến trang đăng nhập
                                // Xác thực cho '/admin/**' (nếu cần)
                                // .requestMatchers("/admin/**").authenticated()
                                .anyRequest().permitAll()  // Cho phép tất cả yêu cầu khác
                )

                // Cấu hình đăng nhập cụ thể cho khu vực admin
                .formLogin(formLogin ->
                        formLogin
                                .loginPage("/admin/login")  // Trang đăng nhập tùy chỉnh cho admin
                                .loginProcessingUrl("/admin/login")  // Xử lý đăng nhập tại URL này
                                .defaultSuccessUrl("/admin", true)  // Trang mặc định sau khi đăng nhập thành công
                                .failureUrl("/admin/login?error=true")  // Chuyển hướng đến đây trong trường hợp đăng nhập thất bại
                )

                // Cấu hình đăng xuất
                .logout(logout ->
                        logout
                                .logoutUrl("/admin/logout")  // Xử lý yêu cầu đăng xuất tại URL này
                                .logoutSuccessUrl("/login")  // Trang sau khi đăng xuất thành công
                );

        return http.build();
    }
}
