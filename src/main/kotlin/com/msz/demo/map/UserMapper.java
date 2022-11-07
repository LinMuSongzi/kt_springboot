package com.msz.demo.map;


import java.io.Serializable;

public interface UserMapper {

    UserOperate register(LoginOperate userMapperWrap);
    UserOperate register(PhoneLoginOperate userMapperWrap);
    UserOperate register(OtherOperate userMapperWrap);

    UserOperate bind(OtherOperate userMapperWrap);
    UserOperate login(LoginOperate loginOperate);
    UserOperate login(PhoneLoginOperate loginOperate);
    UserOperate login(OtherOperate loginOperate);

    abstract class TokenOperate<M> extends BaseOperate<M>{}
    class LoginOperate extends UserOperate{
        String pwd;
        String userName;

        public String getPwd() {
            return pwd;
        }

        public void setPwd(String pwd) {
            this.pwd = pwd;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }
    class PhoneLoginOperate extends UserOperate{
        int code;
        String phone; 
    }
    class OtherOperate  extends UserOperate{
        String verificationString;
        int otherType;
    }

    static class UserOperate extends TokenOperate<UserModel>{}

    static class UserModel extends Model{

    }
    class Model{
        protected long id;
    }

    static class BaseOperate<M> implements Serializable {

        protected M model;
        public M getModel() {
            return model;
        }
        public void setModel(M model) {
            this.model = model;
        }
    }
}
