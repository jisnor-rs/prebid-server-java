package org.prebid.server.functional

import org.prebid.server.functional.repository.HibernateRepositoryService
import org.prebid.server.functional.repository.dao.AccountDao
import org.prebid.server.functional.repository.dao.ConfigDao
import org.prebid.server.functional.repository.dao.StoredImpDao
import org.prebid.server.functional.repository.dao.StoredRequestDao
import org.prebid.server.functional.repository.dao.StoredResponseDao
import org.prebid.server.functional.service.PrebidServerService
import org.prebid.server.functional.testcontainers.PBSTest
import org.prebid.server.functional.testcontainers.PbsServiceFactory
import org.prebid.server.functional.testcontainers.scaffolding.Bidder
import org.prebid.server.functional.testcontainers.scaffolding.PrebidCache
import org.prebid.server.functional.util.ObjectMapperWrapper
import spock.lang.Specification

import static org.prebid.server.functional.testcontainers.Dependencies.mysqlContainer
import static org.prebid.server.functional.testcontainers.Dependencies.networkServiceContainer
import static org.prebid.server.functional.testcontainers.Dependencies.objectMapperWrapper

@PBSTest
abstract class BaseSpec extends Specification {

    protected static final ObjectMapperWrapper mapper = objectMapperWrapper
    protected static final PbsServiceFactory pbsServiceFactory = new PbsServiceFactory(networkServiceContainer, objectMapperWrapper)
    protected static final Bidder bidder = new Bidder(networkServiceContainer, objectMapperWrapper)
    protected static final PrebidCache prebidCache = new PrebidCache(networkServiceContainer, objectMapperWrapper)
    protected static final PrebidServerService defaultPbsService = pbsServiceFactory.getService([:])

    protected static final HibernateRepositoryService repository = new HibernateRepositoryService(mysqlContainer)
    protected static final AccountDao accountDao = repository.accountDao
    protected static final ConfigDao configDao = repository.configDao
    protected static final StoredImpDao storedImp = repository.storedImpDao
    protected static final StoredRequestDao storedRequestDao = repository.storedRequestDao
    protected static final StoredResponseDao storedResponseDao = repository.storedResponseDao

    def setupSpec() {
        prebidCache.setResponse()
        bidder.setResponse()
    }

    def cleanupSpec() {
        bidder.reset()
        prebidCache.reset()
        repository.removeAllDatabaseData()
        pbsServiceFactory.stopContainers()
    }
}
