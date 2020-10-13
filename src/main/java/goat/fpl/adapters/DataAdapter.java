package goat.fpl.adapters;

import goat.fpl.model.*;

import java.io.IOException;
import java.util.Optional;

/**
 * This is like some helper service and it is not designed to be used directly
 * but from other adapters like {@link EntryAdapter}.
 *
 * @Author Filip Miskovic
 * @Email fmiskovic@yandex.com
 */
public interface DataAdapter {

    /**
     * By calling this method you can get data for single fpl team in single game
     * week. Data could be active chips, points, player picks etc. This is useful to
     * get live data for some fpl team.
     *
     * @param entryId     ID of fantasy team.
     * @param eventNumber Game week number.
     * @return POJO EntryPicksRoot parsed from json data.
     * @throws IOException
     * @throws InterruptedException
     */
    Optional<EntryPicksRoot> findEntryEventPicksRoot(long entryId, int eventNumber) throws IOException, InterruptedException;

    /**
     * By calling this method you can get data for single fpl team data.
     * Data could be chips, entry name, origin, bank, leagues of that fpl team, cup,
     * history for all played game weeks etc.
     *
     * @param entryId ID of fantasy team.
     * @return POJO EntryRoot parsed from json data.
     * @throws IOException
     * @throws InterruptedException
     */
    Optional<EntryRoot> findEntryRoot(long entryId) throws IOException, InterruptedException;

    /**
     * By calling this method you can get all transfer history for specified fpl team.
     * Also wild card info, leagues etc.
     *
     * @param entryId ID of fantasy team.
     * @return POJO EntryTransfers parsed from json data.
     * @throws IOException
     * @throws InterruptedException
     */
    Optional<EntryTransfers> findEntryTransfers(long entryId) throws IOException, InterruptedException;

    /**
     * By calling this method you can get data for specified league. Usually it is
     * classic league, but i think it can be Overall. Available data is for example
     * league name, league id, standings which is entry ranking for that league,
     * etc.
     *
     * @param leagueId ID of fpl league.
     * @param page     Single page of 50 entries. Some leagues can have more than 50
     *                 teams, so you must use pagination.
     * @param phase    Phase could be by month (August, September etc) or Overall. 1 =
     *                 Overall, 2 = August, 3 = September etc.
     * @return POJO LeagueRoot parsed from json data.
     * @throws IOException
     * @throws InterruptedException
     */
    Optional<LeagueRoot> findLeagueRoot(long leagueId, long page, int phase) throws IOException, InterruptedException;

    Optional<LiveEvent> findLiveEvent(long eventNumber) throws IOException, InterruptedException;

    /**
     * Retrieve data from bootstrap-static. Here you can find all kind-a useful
     * data like elements(players), events(game weeks), teams(PL teams), phases(Overall, August, September...)
     *
     * @throws IOException
     * @throws InterruptedException
     */
    Optional<BootstrappedData> getBootstrapData() throws IOException, InterruptedException;
}