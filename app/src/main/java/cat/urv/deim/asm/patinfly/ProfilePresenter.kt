package cat.urv.deim.asm.patinfly

class ProfilePresenter(private var ProfileView: ProfileView?):
    ProfileInteractor.OnUpdateListener{

    override fun onSuccess(){
        ProfileView?.navigateToProfile()
    }
}