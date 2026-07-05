# PromptSyntax Experiment History

This directory documents the chronological regression results produced during incremental development of the PromptSyntax compiler.

The files are ordered by run number:

- `1.experiment_results.csv` is the earliest recorded run.
- `21.experiment_results.csv` is the final recorded run.
- Each file is a complete regression execution at that development stage.
- Later files repeat earlier tests and add tests for newly implemented features.

Historical rows must **not** be aggregated as independent observations because the same benchmark programs are rerun across milestones.

## Authoritative result

The authoritative result used in the paper is:

```text
21.experiment_results.csv
```

It contains the final benchmark suite:

- 10 valid PromptSyntax programs;
- 16 invalid PromptSyntax programs;
- 26 total programs; and
- 26 observed outcomes matching their expected success/failure labels.

Runs 20 and 21 have the same recorded size and modification time in the archived experiment folder. They should therefore be treated as repeated captures of the final regression state unless a byte-level comparison shows otherwise. Run 21 is retained as the canonical paper result.

## How the mapping was reconstructed

The run-to-feature mapping below was reconstructed from three sources:

1. the numerical order of the CSV files;
2. each CSV file's modification time; and
3. the nearest preceding implementation and test commits in the Git history.

For closely timed runs, the newly appearing benchmark filenames and generated diagnostics were also used to identify the exercised feature. A feature may be implemented locally, tested, and committed a few seconds or minutes after the corresponding CSV was written; therefore, commit time is supporting evidence rather than an exact execution timestamp.

## Experiment evolution

| Run | Result file | Compiler state or feature exercised before the run | Representative Git evidence |
|---:|---|---|---|
| 1 | `1.experiment_results.csv` | Initial source-to-prompt compiler scaffold and first executable pipeline | `4d6f862`, `d17b705` |
| 2 | `2.experiment_results.csv` | Initial valid/invalid evaluation corpus | `778ae2b` |
| 3 | `3.experiment_results.csv` | Automated regression runner and CSV recording | `fccb59b` |
| 4 | `4.experiment_results.csv` | Multi-backend prompt generation, PromptIR v2, and backend-format stabilization | `0e9ed80`, `e11ab07`, `f7121cc` |
| 5 | `5.experiment_results.csv` | Registry-based type resolution and initial relationship extraction work | `19cca5b`, `aa9ee4a` |
| 6 | `6.experiment_results.csv` | Repeated regression capture around the type/relationship milestone | `19cca5b`, `aa9ee4a` |
| 7 | `7.experiment_results.csv` | Relationship-aware PromptIR and relationship rendering across backends | `aa9ee4a`, `7959b35` |
| 8 | `8.experiment_results.csv` | Enumeration declarations and enum-aware backend output | `73aa08f`, `3cf522a` |
| 9 | `9.experiment_results.csv` | Generic type support plus invalid generic-type cases | `33c7e75`, `6d83940` |
| 10 | `10.experiment_results.csv` | Method declarations in entities | `ad00614` |
| 11 | `11.experiment_results.csv` | Method parameter and return-type validation | `6e56d7a` |
| 12 | `12.experiment_results.csv` | Duplicate method and duplicate parameter checks | `63aeb1b` |
| 13 | `13.experiment_results.csv` | Repeated regression capture after duplicate method/parameter validation | `63aeb1b` |
| 14 | `14experiment_results.csv` | Inheritance semantic validation, including unknown-parent and self-inheritance cases | `3332163` |
| 15 | `15.experiment_results.csv` | First interface semantic-validation milestone | `19cfd8d` |
| 16 | `16.experiment_results.csv` | Revised/finalized interface semantic validation | `47ae431` |
| 17 | `17.experiment_results.csv` | Stable interface-aware regression state before contract support | `47ae431` |
| 18 | `18.experiment_results.csv` | Method contracts (`requires` and `ensures`) added to the language and PromptIR | `f0aba4f` |
| 19 | `19.experiment_results.csv` | Contract-aware output across all five backends | `a3b6fb8` |
| 20 | `20.experiment_results.csv` | Invalid contract syntax tests and module/namespace feature integrated in the working tree | `e2f1d8d`, `e585cba` |
| 21 | `21.experiment_results.csv` | Final regression capture: modules plus the complete 10-valid/16-invalid suite | `e585cba` |

## Interpretation of repeated runs

Several adjacent files have identical sizes and/or modification times. These are retained as provenance records, but they do not represent new independent benchmark observations. In particular:

- runs 5 and 6 appear to be repeated captures around the same type/relationship milestone;
- runs 12 and 13 appear to be repeated captures after method-duplicate validation; and
- runs 20 and 21 appear to be repeated captures of the final benchmark state.

The historical sequence is useful for documenting incremental development, regression discipline, and artifact provenance. Quantitative claims in the paper must use only the final authoritative run.

## Final benchmark composition

### Valid programs

```text
bank_account.psx
book.psx
contract_account.psx
enrollment.psx
enum_student.psx
generic_course.psx
interface_student.psx
method_student.psx
module_student.psx
student.psx
```

### Invalid programs

```text
builder_without_constructor.psx
contract_missing_expression.psx
contract_missing_semicolon.psx
duplicate_field.psx
duplicate_interface_field.psx
duplicate_method.psx
duplicate_parameter.psx
run_tests_without_tests.psx
self_inheritance.psx
unknown_generic_inner_type.psx
unknown_interface.psx
unknown_map_value_type.psx
unknown_method_parameter_type.psx
unknown_method_return_type.psx
unknown_parent.psx
unknown_type.psx
```

## Reproducing the final run

From the repository root on Windows PowerShell:

```powershell
mvn clean package
powershell -ExecutionPolicy Bypass -File scripts/run_experiment.ps1
```

The script writes the current result to:

```text
results/experiment_results.csv
```

The experiment oracle compares only the compiler process outcome with the expected label:

- valid programs are expected to exit successfully; and
- invalid programs are expected to exit with failure.

Diagnostic text is stored in the CSV for inspection, but the current script does not automatically compare each diagnostic against a per-test expected message.

## Recommended paper wording

> The benchmark suite was developed incrementally alongside the compiler. After each major language or validation extension, the available regression suite was rerun. Historical result files are retained as artifact provenance, while quantitative results in the paper are drawn exclusively from the final run containing 10 valid and 16 invalid programs.
