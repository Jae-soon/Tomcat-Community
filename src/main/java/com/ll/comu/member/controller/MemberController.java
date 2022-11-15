package com.ll.comu.member.controller;

import com.ll.comu.global.Rq;

public class MemberController {
    public void showLogin(Rq rq) {
        rq.appendBody("로그인 화면");
    }
}
