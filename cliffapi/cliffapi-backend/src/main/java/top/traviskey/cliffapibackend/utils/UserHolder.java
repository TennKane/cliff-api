package top.traviskey.cliffapibackend.utils;


import top.traviskey.cliffapicommon.model.vo.LoginUserVO;

public class UserHolder {
    private static final ThreadLocal<LoginUserVO> tl = new ThreadLocal<>();

    public static void saveUser(LoginUserVO user){
        tl.set(user);
    }

    public static LoginUserVO getUser(){
        return tl.get();
    }

    public static boolean isLogin(){return tl.get() !=null;}

    public static void removeUser(){
        tl.remove();
    }
}
