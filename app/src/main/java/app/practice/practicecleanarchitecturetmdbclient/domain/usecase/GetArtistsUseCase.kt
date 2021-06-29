package app.practice.practicecleanarchitecturetmdbclient.domain.usecase

import app.practice.practicecleanarchitecturetmdbclient.data.model.artist.Artist
import app.practice.practicecleanarchitecturetmdbclient.data.repository.artist.ArtistRepository
import javax.inject.Inject

interface GetArtistsUseCase {
    suspend fun execute(): List<Artist>
}

class GetArtistsUseCaseImpl @Inject constructor(
    private val artistRepository: ArtistRepository
) : GetArtistsUseCase {

    override suspend fun execute(): List<Artist> {
        return artistRepository.getArtists()
    }

}