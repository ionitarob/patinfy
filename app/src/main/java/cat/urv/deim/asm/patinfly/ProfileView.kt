package cat.urv.deim.asm.patinfly

interface ProfileView {
    fun showProgress()
    fun hideProgress()
    fun setFirstNameError()
    fun setLastNameError()
    fun setEmailError()
    fun setPhoneError()
    fun setIDError()
    fun setNationalityError()
    fun setKmError()
    fun navigateToProfile()
}