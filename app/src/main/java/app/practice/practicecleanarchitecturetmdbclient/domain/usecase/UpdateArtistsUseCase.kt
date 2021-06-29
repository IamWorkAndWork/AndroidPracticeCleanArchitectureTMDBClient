package app.practice.practicecleanarchitecturetmdbclient.domain.usecase

import app.practice.practicecleanarchitecturetmdbclient.data.model.artist.Artist
import app.practice.practicecleanarchitecturetmdbclient.data.repository.artist.ArtistRepository
import javax.inject.Inject

interface UpdateArtistsUseCase {
    suspend fun execute(): List<Artist>
}

class UpdateArtistsUseCaseImpl @Inject constructor(
    private val artistRepository: ArtistRepository
):UpdateArtistsUseCase{

    override suspend fun execute(): List<Artist> {
        return artistRepository.getArtists()
    }

}