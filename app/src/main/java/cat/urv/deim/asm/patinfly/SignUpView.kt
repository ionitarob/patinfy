package cat.urv.deim.asm.patinfly

interface SignUpView {
    fun showProgress()
    fun hideProgress()
    fun setFirstNameError()
    fun setLastNameError()
    fun setEmailError()
    fun setPhoneError()
    fun setIDError()
    fun setNationalityError()
    fun setKm()
    fun navigateToPassword()
}