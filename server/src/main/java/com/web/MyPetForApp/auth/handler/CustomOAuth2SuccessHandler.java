package com.web.MyPetForApp.auth.handler;

import com.web.MyPetForApp.auth.provider.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;

@Component
@RequiredArgsConstructor
public class CustomOAuth2SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private final TokenProvider tokenProvider;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {


        DefaultOAuth2User oAuth2User = (DefaultOAuth2User) authentication.getPrincipal();

        String memberId = (String) oAuth2User.getAttributes().get("memberName");
        String email = (String) oAuth2User.getAttributes().get("email");

        String accessToken = tokenProvider.createAccessToken(memberId, email);
        String refreshToken = tokenProvider.renewalRefreshToken(memberId, email);

        System.out.println("소셜 로그인 성공 유저 : " + email);

        String uri = createURI(accessToken, refreshToken).toString();
        getRedirectStrategy().sendRedirect(request, response, uri);
//        response.addHeader("Access-Control-Allow-Origin", "*");

//        getRedirectStrategy().sendRedirect(request, response, "http://49.165.248.183:3000");
//        getDefaultTargetUrl()
////        getRedirectStrategy().sendRedirect(request, response, "/login/oauth2");
//        RequestDispatcher rd = request.getRequestDispatcher("http://localhost:8080");
//        rd.forward(request,response);

//        getRedirectStrategy().sendRedirect(request, response, "https://seb39-main-003-gamma.vercel.app");
//        getRedirectStrategy().sendRedirect(request, response, "https://seb39-main-003-gadt7n9o7-nomga.vercel.app");
//        getRedirectStrategy().sendRedirect(request, response, "https://seb39-main-003-kslsp3cga-nomga.vercel.app");
    }

    private URI createURI(String accessToken, String refreshToken) {
        MultiValueMap<String, String> queryParmas = new LinkedMultiValueMap<>();
        queryParmas.add("access_token", accessToken);
        queryParmas.add("refresh_token", refreshToken);

        return UriComponentsBuilder
                .newInstance()
                .scheme("http")
                .host("localhost")
                .port("8080")
                .path("/")
                .queryParams(queryParmas)
                .build()
                .toUri();
    }
}
