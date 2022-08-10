package com.funmunity.myapp.member;

public interface MemberDAO {
    int RegisterUser(MemberDTO dto);

    MemberDTO userLogin(String user_id, String user_pw);
}
