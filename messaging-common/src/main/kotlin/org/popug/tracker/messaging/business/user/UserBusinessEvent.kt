package org.popug.tracker.messaging.business.user

import org.popug.tracker.messaging.Message
import org.popug.tracker.messaging.MessageSource.Business.Users.USER_REGISTERED
import org.popug.tracker.messaging.business.BusinessEvent
import org.popug.tracker.messaging.business.BusinessEventPayload
import org.popug.tracker.messaging.business.user.UserRegisteredBusinessEvent.UserRegisteredBusinessEventPayload

data class UserRegisteredBusinessEvent(override val payload: UserRegisteredBusinessEventPayload) :
    BusinessEvent<UserRegisteredBusinessEventPayload> {

    override val metadata: Message.Metadata =
        Message.Metadata(key = payload.userPublicId, destinationTopic = USER_REGISTERED)

    data class UserRegisteredBusinessEventPayload(
        val userPublicId: String,
        val firstName: String,
        val lastName: String,
        val email: String
    ) : BusinessEventPayload
}

data class Dummy(val dummyValue: String)
