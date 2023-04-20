package cat.urv.deim.asm.patinfly

interface LoginView {
    fun showProgress()
    fun hideProgress()
    fun setUserError()
    fun setPasswordError()
    fun navigateToSignUp()
    fun navigateToProfile()
}