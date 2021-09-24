package com.rtk.mpbg.ui.home

import com.rtk.mpbg.core.exception.Failure
import com.rtk.mpbg.core.utils.Either
import com.rtk.mpbg.core.utils.UseCase
import javax.inject.Inject

class GetMobiles
@Inject constructor(private val mobileRepository: MobileRepository): UseCase<List<Mobile>, UseCase.None>() {

    override suspend fun run(params: None) = mobileRepository.mobiles()
}