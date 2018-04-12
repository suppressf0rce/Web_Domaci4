package model;

public class User {

    private String userName;
    private String password;

    private User(Builder builder){
        this.userName = builder.userName;
        this.password = builder.password;
    }

    @Override
    public String toString() {
        return "["+ userName +" - "+ password;
    }

    //Builder <<--------------------------------------------------------------------------------------------------------
    public static class Builder {

        private String userName;
        private String password;

        public Builder userName(String firstName) {
            this.userName = firstName;
            return this;
        }

        public Builder password(String lastName) {
            this.password = lastName;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }
}