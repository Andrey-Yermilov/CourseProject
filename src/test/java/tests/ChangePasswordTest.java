package tests;

import UI.forms.EditProfileForm;
import UI.forms.LoginForm;
import UI.forms.MainForm;
import UI.forms.ProfileForm;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import webdriver.BaseTest;

import java.io.FileInputStream;

public class ChangePasswordTest extends BaseTest {

    private String currentPassword;
    private String newPassword;
    private String username;
    private String typeOfLogin;
    private String typeOfUserProfileTab;
    private String passwordPath;

    @Test
    @Parameters({ "username", "typeOfUserProfileTab","typeOfLogin", "passwordPath"})
    public void readParams(String username, String typeOfUserProfileTab, String typeOfLogin, String passwordPath) throws Throwable{
        this.username = username;
        this.typeOfUserProfileTab = typeOfUserProfileTab;
        this.typeOfLogin = typeOfLogin;
        this.username = username;
        this.passwordPath = passwordPath;
        FileInputStream fileInputStream = new FileInputStream(passwordPath);
        byte[] tmp = new byte[12];
        fileInputStream.read(tmp);
        this.currentPassword = new String(tmp);
        xTest();
    }

    @Test (enabled = false)
    public void xTest() throws Throwable {
        super.xTest();
    }

    public void runTest() {
        logger.step(1);
        MainForm mainForm = new MainForm();

        logger.step(2);
        mainForm.getLoginMenu().openLoginForm(typeOfLogin);
        LoginForm loginForm = new LoginForm();
        loginForm.login(username, currentPassword);
        mainForm.assertLoggedIn(username);

        logger.step(3);
        mainForm.goToProfileForm();
        ProfileForm profileForm = new ProfileForm();
        profileForm.openEditProfileForm();
        EditProfileForm editProfileForm = new EditProfileForm();
        editProfileForm.openTab(typeOfUserProfileTab);

        logger.step(4);
        newPassword = editProfileForm.generateNewPassword(currentPassword);
        editProfileForm.changePassword(currentPassword,newPassword);
        mainForm.exit();
        LoginForm loginFormAfterLoginOut = new LoginForm();

        logger.step(5);
        loginFormAfterLoginOut.login(username, newPassword);
        mainForm.assertLoggedIn(username);
        mainForm.writeToFile(newPassword,passwordPath);
    }
}


