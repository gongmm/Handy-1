package com.example.handy.di.module.base;

import com.example.handy.di.component.BaseFragmentComponent;
import com.example.handy.di.module.FollowPagerFragmentModule;
import com.example.handy.di.module.MainPagerFragmentModule;
import com.example.handy.view.fragment.FollowPagerFragment;
import com.example.handy.view.fragment.MainPagerFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * @author quchao
 * @date 2018/5/4
 */

@Module(subcomponents = BaseFragmentComponent.class)
public abstract class AbstractAllFragmentModule {

    //@ContributesAndroidInjector(modules = SettingFragmentModule.class)
    //abstract SettingFragment contributesSettingFragmentInject();
    @ContributesAndroidInjector(modules = MainPagerFragmentModule.class)
    abstract MainPagerFragment contributesMainPagerFragmentInject();

    @ContributesAndroidInjector(modules = FollowPagerFragmentModule.class)
    abstract FollowPagerFragment contributesFollowPagerFragmentInject();

}
