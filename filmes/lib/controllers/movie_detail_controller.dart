class MovieDetailController {
  final _repository = MovieRespository();

  MovieDetailModel movieDetail;
  MovieError movieError;

  bool loading = true;

  Future<Either<MovieError, MovieDetailModel>> fetchMovieById(int id) async {
    movieError = null;
    final result = await _repository.fetchMovieById(id);
    result.fold(
          (error) => movieError = error,
          (detail) => movieDetail = detail,
    );
    return result;
  }
}