package cat.urv.deim.asm.patinfly

interface PasswordView {
    fun showProgress()
    fun hideProgress()
    fun setPasswordError()
    fun setPasswordRepeatError()
    fun navigateToProfile()
}