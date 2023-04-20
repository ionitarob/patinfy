package cat.urv.deim.asm.patinfly

class LoginPresenter(private var loginView: LoginView?, private var loginInteractor: LoginInteractor):
    LoginInteractor.OnLoginListener, LoginInteractor.OnSignUpListener {

    fun verifyData(username: String, password: String): Boolean {
        loginView?.showProgress()
        return loginInteractor.login(username, password, this)
    }

    override fun setUserError() {
        loginView?.apply {
            setUserError()
            hideProgress()
        }
    }

    override fun setPasswordError() {
        loginView?.apply {
            setPasswordError()
            hideProgress()
        }
    }

    override fun onSuccess() {
        loginView?.navigateToProfile()
    }

    override fun onSignUp() {
        loginView?.navigateToSignUp()
    }
}