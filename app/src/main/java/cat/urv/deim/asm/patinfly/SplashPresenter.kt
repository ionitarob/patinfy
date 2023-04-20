package cat.urv.deim.asm.patinfly

class SplashPresenter(var SplashView: SplashView?):
    SplashInteractor.OnSplashFinishedListener {

    override fun onSuccess() {
        postDelayed(2000){
            SplashView?.navigateToTutorial()
        }
    }
}
