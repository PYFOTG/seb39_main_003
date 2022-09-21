//package com.web.MyPetForApp.auth.dto;
//
//import com.web.MyPetForApp.member.entity.Member;
//import lombok.Data;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.ArrayList;
//import java.util.Collection;
//
//@Data
//public class AuthDetails implements UserDetails {
//    private final Member member;
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        Collection<GrantedAuthority> authorities = new ArrayList<>();
//        authorities.add(() -> String.valueOf(member.getMemberRole()));
//        return authorities;
//    }
//
////    @Override
////    public Collection<? extends GrantedAuthority> getAuthorities() {
////        Collection<GrantedAuthority> authorities = new ArrayList<>();
////        member.getRoleList().forEach(n -> {
////            authorities.add(() -> n);
////        });
////        return authorities;
////    }
//
//    public String getEmail() {return member.getEmail();}
//
//    @Override
//    public String getPassword() {
//        return member.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return member.getEmail();
//    }
//
//    // 사용자의 사용기간이 정해진 경우 사용 -> 회원의 만료기간을 보고 만료됐는지 안됐는지 여기에 넣는다.
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
