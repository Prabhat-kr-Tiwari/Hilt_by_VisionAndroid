package com.example.daggerhilt

import android.util.Log
import com.example.daggerhilt.mvvm.MyRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object HiltModules
{



    @Provides

    fun provideEngine(piston: Piston):Engine{
        return Engine(piston)

    }

    @Provides
    fun provideCar(engine: Engine,@Five number:Int):Car{
        return Car(engine,number);
    }

    @Provides
    fun providePiston(numberOfPiston: NumberOfPiston):Piston{
        return Piston(numberOfPiston)
    }

    @Provides
    fun provideNumberOfPiston():NumberOfPiston{
        return NumberOfPistonImpl()
    }



    @Provides
    @Four
    fun provideFourInt():Int{
        return 4
    }

    @Provides
    @Five
    fun provideSixInt():Int{
        return 5
    }


    @Provides
    fun provideMyRepo(car: Car):MyRepo{

        return MyRepo(car)

    }
}


@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Four

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Five





























