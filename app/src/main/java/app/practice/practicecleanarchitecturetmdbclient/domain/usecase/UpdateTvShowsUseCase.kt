package app.practice.practicecleanarchitecturetmdbclient.domain.usecase

import app.practice.practicecleanarchitecturetmdbclient.data.model.tvshow.TvShow
import app.practice.practicecleanarchitecturetmdbclient.data.repository.tvshow.TvShowRepository
import javax.inject.Inject

interface UpdateTvShowsUseCase {
    suspend fun execute(): List<TvShow>
}

class UpdateTvShowsUseCaseImpl @Inject constructor(
    private val tvShowRepository: TvShowRepository
) : UpdateTvShowsUseCase {

    override suspend fun execute(): List<TvShow> {
        return tvShowRepository.getTvShows()
    }

}