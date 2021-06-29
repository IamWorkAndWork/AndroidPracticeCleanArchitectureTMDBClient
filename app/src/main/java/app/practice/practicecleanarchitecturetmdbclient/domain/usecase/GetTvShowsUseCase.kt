package app.practice.practicecleanarchitecturetmdbclient.domain.usecase

import app.practice.practicecleanarchitecturetmdbclient.data.model.tvshow.TvShow
import app.practice.practicecleanarchitecturetmdbclient.data.repository.tvshow.TvShowRepository
import javax.inject.Inject

interface GetTvShowsUseCase {
    suspend fun execute(): List<TvShow>
}

class GetTvShowsUseCaseImpl @Inject constructor(
    private val tvShowRepository: TvShowRepository
) :GetTvShowsUseCase{

    override suspend fun execute(): List<TvShow> {
        return tvShowRepository.getTvShows()
    }

}