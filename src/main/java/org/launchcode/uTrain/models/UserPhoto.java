package org.launchcode.uTrain.models;

import org.launchcode.uTrain.models.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class UserPhoto extends AbstractEntity {

    @OneToOne
    private User user;
//    @OneToMany
//    private  List<User> users = new ArrayList<>();

    private String profilePic;


//    private String profilePicImagePath;

    public UserPhoto() {}

    public UserPhoto(String profilePic){
        this.profilePic = profilePic;
    }


    public String getProfilePic() {
        return profilePic;
    }

    public String setProfilePic(String profilePic) {
        this.profilePic = profilePic;
        return profilePic;
    }

    @Transient
    public String getPhotoImagePath() {
        if (profilePic == null) return null;

        return "/profilePic/" + profilePic;
    }
//
//    public List<User> getUsers() {
//        return users;
//    }
//
//    public void setUsers(List<User> users) {
//        this.users = users;
//    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
