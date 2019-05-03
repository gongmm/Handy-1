package com.example.handy.presenter;

import com.example.handy.R;
import com.example.handy.app.Constants;
import com.example.handy.app.HandyAPP;
import com.example.handy.base.presenter.BasePresenter;
import com.example.handy.contract.AccountPagerContract;
import com.example.handy.contract.CollectPagerContract;
import com.example.handy.core.DataManager;
import com.example.handy.core.bean.FollowData;
import com.example.handy.core.bean.UserInfoData;
import com.example.handy.utils.RxUtils;
import com.example.handy.view.fragment.AccountPagerFragment;
import com.example.handy.wigdet.BaseObserver;

import java.util.List;

import javax.inject.Inject;

public class AccountPagerPresenter extends BasePresenter<AccountPagerContract.View> implements AccountPagerContract.Presenter {

    private DataManager mDataManager;
    private int mCurrentPage;
    private boolean isRefresh = true;

    @Inject
    public AccountPagerPresenter(DataManager dataManager) {
        super(dataManager);
        this.mDataManager = dataManager;
    }

    @Override
    public int getLoginAccount() {
        return mDataManager.getLoginAccount();
    }

    @Override
    public void autoRefresh(boolean isShowError) {
        isRefresh = true;
        mCurrentPage = 0;
    }

    @Override
    public void loadMore() {
        isRefresh = false;
        mCurrentPage++;
    }

    @Override
    public void loadMoreData() {

    }

    @Override
    public void getMyCourse(boolean isShowError) {

    }

    @Override
    public void getMyAlbum(boolean isShowError) {

    }

    @Override
    public void getUserInfo(boolean isShowError){
        addSubscribe(mDataManager.getUserInfo(getLoginAccount())
                .compose(RxUtils.rxSchedulerHelper())
                .compose(RxUtils.handleResult())
                .subscribeWith(new BaseObserver<UserInfoData>(mView,
                        HandyAPP.getInstance().getString(R.string.failed_to_obtain_follow_data),
                        isShowError) {
                    @Override
                    public void onNext(UserInfoData userInfoData) {
                        mView.showUserInfo(userInfoData);
                    }
                }));

    }
}
