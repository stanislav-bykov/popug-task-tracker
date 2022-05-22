package org.popug.tracker.accounting.messaging.service.user.streaming.create

import org.popug.tracker.accounting.dal.model.account.Account
import org.popug.tracker.accounting.dal.repository.account.AccountRepository
import org.popug.tracker.core.business.BusinessService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class Service(
    private val accountRepository: AccountRepository
) : BusinessService<Api.Request, Unit> {

    @Transactional
    override fun invoke(request: Api.Request) {
        accountRepository.save(request.toEntity())
    }

    private companion object {
        fun Api.Request.toEntity() =
            Account(
                publicId = publicId,
                firstName = firstName,
                lastName = lastName
            )
    }
}